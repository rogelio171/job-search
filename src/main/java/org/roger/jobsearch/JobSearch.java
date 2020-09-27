package org.roger.jobsearch;

import com.beust.jcommander.JCommander;
import org.roger.jobsearch.api.ApiJobs;
import org.roger.jobsearch.cli.CliArguments;
import org.roger.jobsearch.cli.CliFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.roger.jobsearch.CommanderFunctions.buildCommanderWithName;
import static org.roger.jobsearch.CommanderFunctions.parseArguments;
import static org.roger.jobsearch.api.ApiFunctions.buildApi;

public class JobSearch {
    public static void main(String[] args) {
        JCommander jCommander = buildCommanderWithName("job-search", CliArguments::newInstance);

        Stream<CliArguments> cliArgumentsStream = parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj -> (CliArguments) obj);

        Optional<CliArguments> cliArguments =
                cliArgumentsStream.filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        cliArguments.map(CliFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        ApiJobs apiJobs = buildApi(ApiJobs.class, "https://jobs.github.com" );

        return Stream.of(params)
                .map(apiJobs::jobs)
                .flatMap(Collection::stream);
    }
}

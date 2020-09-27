package org.roger.jobsearch.cli;

import com.beust.jcommander.Parameter;

import lombok.Data;

@Data
public class CliArguments {
    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            validateWith = CliKeywordValidator.class,
            description = "A search term, such as \"python\" or \"java\"."
    )
    String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "A city name, zip code, or other location search term."
    )
    String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "Each page will only return 50 positions at a time."
    )
    Integer page;

    @Parameter(
            names = {"--full-time"},
            description = "If you want to limit results to full time positions set this parameter to 'true'."
    )
    boolean fullTime;

    @Parameter(
            names = {"--markdown", "-md"},
            description = "Show the description and how_to_apply fields as Markdown."
    )
    boolean markdown;

    @Parameter(
            names = {"--help"},
            help = true,
            validateWith = CliHelpValidator.class,
            description = "Shows the help."
    )
    boolean help;

    public static CliArguments newInstance() {
        return new CliArguments();
    }
}

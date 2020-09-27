package org.roger.jobsearch.api;

import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import org.roger.jobsearch.JobPosition;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface ApiJobs {

    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
}

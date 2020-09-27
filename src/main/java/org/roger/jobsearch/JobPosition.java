package org.roger.jobsearch;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class JobPosition {
    String id;
    String type;
    String url;

    @SerializedName("created_at")
    String createdAt;

    String company;

    @SerializedName("company_url")
    String companyUrl;

    String title;
    String location;
    String description;

    @SerializedName("company_logo")
    String companyLogo;
}

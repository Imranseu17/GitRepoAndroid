package com.repository.androidrepository.models

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(tableName = "items")
@Parcelize
data class Items (

  @PrimaryKey()
  @JsonProperty("id"                ) var id               : Int? = null,
  @JsonProperty("node_id"           ) var nodeId           : String? = null,
  @JsonProperty("name"              ) var name             : String? = null,
  @JsonProperty("full_name"         ) var fullName         : String? = null,
  @JsonProperty("private"           ) var private          : Boolean? = null,
  @Embedded
  @JsonProperty("owner"             ) var owner            : Owner? = null,
  @JsonProperty("html_url"          ) var htmlUrl          : String? = null,
  @JsonProperty("description"       ) var description      : String? = null,
  @JsonProperty("fork"              ) var fork             : Boolean? = null,
  @JsonProperty("url"               ) var url              : String? = null,
  @JsonProperty("forks_url"         ) var forksUrl         : String? = null,
  @JsonProperty("keys_url"          ) var keysUrl          : String? = null,
  @JsonProperty("collaborators_url" ) var collaboratorsUrl : String? = null,
  @JsonProperty("teams_url"         ) var teamsUrl         : String? = null,
  @JsonProperty("hooks_url"         ) var hooksUrl         : String? = null,
  @JsonProperty("issue_events_url"  ) var issueEventsUrl   : String? = null,
  @JsonProperty("events_url"        ) var eventsUrl        : String? = null,
  @JsonProperty("assignees_url"     ) var assigneesUrl     : String? = null,
  @JsonProperty("branches_url"      ) var branchesUrl      : String? = null,
  @JsonProperty("tags_url"          ) var tagsUrl          : String? = null,
  @JsonProperty("blobs_url"         ) var blobsUrl         : String? = null,
  @JsonProperty("git_tags_url"      ) var gitTagsUrl       : String? = null,
  @JsonProperty("git_refs_url"      ) var gitRefsUrl       : String? = null,
  @JsonProperty("trees_url"         ) var treesUrl         : String? = null,
  @JsonProperty("statuses_url"      ) var statusesUrl      : String? = null,
  @JsonProperty("languages_url"     ) var languagesUrl     : String? = null,
  @JsonProperty("stargazers_url"    ) var stargazersUrl    : String? = null,
  @JsonProperty("contributors_url"  ) var contributorsUrl  : String? = null,
  @JsonProperty("subscribers_url"   ) var subscribersUrl   : String? = null,
  @JsonProperty("subscription_url"  ) var subscriptionUrl  : String? = null,
  @JsonProperty("commits_url"       ) var commitsUrl       : String? = null,
  @JsonProperty("git_commits_url"   ) var gitCommitsUrl    : String? = null,
  @JsonProperty("comments_url"      ) var commentsUrl      : String? = null,
  @JsonProperty("issue_comment_url" ) var issueCommentUrl  : String? = null,
  @JsonProperty("contents_url"      ) var contentsUrl      : String? = null,
  @JsonProperty("compare_url"       ) var compareUrl       : String? = null,
  @JsonProperty("merges_url"        ) var mergesUrl        : String? = null,
  @JsonProperty("archive_url"       ) var archiveUrl       : String? = null,
  @JsonProperty("downloads_url"     ) var downloadsUrl     : String? = null,
  @JsonProperty("issues_url"        ) var issuesUrl        : String? = null,
  @JsonProperty("pulls_url"         ) var pullsUrl         : String? = null,
  @JsonProperty("milestones_url"    ) var milestonesUrl    : String? = null,
  @JsonProperty("notifications_url" ) var notificationsUrl : String? = null,
  @JsonProperty("labels_url"        ) var labelsUrl        : String? = null,
  @JsonProperty("releases_url"      ) var releasesUrl      : String? = null,
  @JsonProperty("deployments_url"   ) var deploymentsUrl   : String? = null,
  @JsonProperty("created_at"        ) var createdAt        : String? = null,
  @JsonProperty("updated_at"        ) var updatedAt        : String? = null,
  @JsonProperty("pushed_at"         ) var pushedAt         : String? = null,
  @JsonProperty("git_url"           ) var gitUrl           : String? = null,
  @JsonProperty("ssh_url"           ) var sshUrl           : String? = null,
  @JsonProperty("clone_url"         ) var cloneUrl         : String? = null,
  @JsonProperty("svn_url"           ) var svnUrl           : String? = null,
  @JsonProperty("homepage"          ) var homepage         : String? = null,
  @JsonProperty("size"              ) var item_size        : Int? = null,
  @JsonProperty("stargazers_count"  ) var stargazersCount  : Int ? = null,
  @JsonProperty("watchers_count"    ) var watchersCount    : Int ? = null,
  @JsonProperty("language"          ) var language         : String? = null,
  @JsonProperty("has_issues"        ) var hasIssues        : Boolean? = null,
  @JsonProperty("has_projects"      ) var hasProjects      : Boolean? = null,
  @JsonProperty("has_downloads"     ) var hasDownloads     : Boolean? = null,
  @JsonProperty("has_wiki"          ) var hasWiki          : Boolean? = null,
  @JsonProperty("has_pages"         ) var hasPages         : Boolean? = null,
  @JsonProperty("forks_count"       ) var forksCount       : Int? = null,
  @JsonProperty("mirror_url"        ) var mirrorUrl        : String? = null,
  @JsonProperty("archived"          ) var archived         : Boolean? = null,
  @JsonProperty("disabled"          ) var disabled         : Boolean? = null,
  @JsonProperty("open_issues_count" ) var openIssuesCount  : Int? = null,
  @Embedded
  @JsonProperty("license"           ) var license          : License? = null,
  @JsonProperty("allow_forking"     ) var allowForking     : Boolean? = null,
  @JsonProperty("is_template"       ) var isTemplate       : Boolean? = null,
  @Embedded
  @Ignore
  @JsonProperty("topics"            ) var topics           : ArrayList<String>? = null,
  @JsonProperty("visibility"        ) var visibility       : String? = null,
  @JsonProperty("forks"             ) var forks            : Int? = null,
  @JsonProperty("open_issues"       ) var openIssues       : Int? = null,
  @JsonProperty("watchers"          ) var watchers         : Int? = null,
  @JsonProperty("default_branch"    ) var defaultBranch    : String? = null,
  @JsonProperty("score"             ) var score            : Int? = null

):Parcelable{

  constructor():this(0,"","","",false, Owner(),"","",
  false,"","","","","","","","",
    "","","","","","","","","",
  "","","","","","","",
    "","","","","","","","",
    "","","","","","","","",
  "","","","","",0,0,0,"",
    false,false,false,false,false,0,"",
  false,false,0, License(),false,false, arrayListOf
 (),"",0,0,0,"",0)
}
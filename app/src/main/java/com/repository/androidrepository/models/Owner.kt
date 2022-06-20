package com.repository.androidrepository.models

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize


@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class Owner (

 @JsonProperty("login"               ) var owner_login             : String? = null,
 @JsonProperty("id"                  ) var owner_id                : Int? = null,
 @JsonProperty("node_id"             ) var owner_nodeId            : String? = null,
 @JsonProperty("avatar_url"          ) var owner_avatarUrl         : String? = null,
 @JsonProperty("gravatar_id"         ) var owner_gravatarId        : String? = null,
 @JsonProperty("url"                 ) var owner_url               : String? = null,
 @JsonProperty("html_url"            ) var owner_htmlUrl           : String? = null,
 @JsonProperty("followers_url"       ) var owner_followersUrl      : String? = null,
 @JsonProperty("following_url"       ) var owner_followingUrl      : String? = null,
 @JsonProperty("gists_url"           ) var owner_gistsUrl          : String? = null,
 @JsonProperty("starred_url"         ) var owner_starredUrl        : String? = null,
 @JsonProperty("subscriptions_url"   ) var owner_subscriptionsUrl  : String? = null,
 @JsonProperty("organizations_url"   ) var owner_organizationsUrl  : String? = null,
 @JsonProperty("repos_url"           ) var owner_reposUrl          : String? = null,
 @JsonProperty("events_url"          ) var owner_eventsUrl         : String? = null,
 @JsonProperty("received_events_url" ) var owner_receivedEventsUrl : String? = null,
 @JsonProperty("type"                ) var owner_type              : String? = null,
 @JsonProperty("site_admin"          ) var owner_siteAdmin         : Boolean? = null

):Parcelable{
  constructor():this("",0,"","","",
   "","","","","","",
   "","","","","",
   "",false)
}
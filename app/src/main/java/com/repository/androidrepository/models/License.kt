package com.repository.androidrepository.models

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize


@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class License (

 @JsonProperty("key"     ) var license_key    : String? = null,
 @JsonProperty("name"    ) var license_name   : String? = null,
 @JsonProperty("spdx_id" ) var license_spdxId : String? = null,
 @JsonProperty("url"     ) var license_url    : String? = null,
 @JsonProperty("node_id" ) var license_nodeId : String? = null

):Parcelable{

 constructor():this("","","","","")
}
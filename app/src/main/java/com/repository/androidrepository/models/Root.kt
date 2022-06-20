package com.repository.androidrepository.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


@JsonIgnoreProperties(ignoreUnknown = true)
data class Root (

  @JsonProperty("total_count"        ) var totalCount        : Int? = null,
  @JsonProperty("incomplete_results" ) var incompleteResults : Boolean? = null,
  @JsonProperty("items"              ) var items             : ArrayList<Items>? = null

)
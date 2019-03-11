package model.entities

import service.date.Date

data class Person(val firstName: String,
                  val surname: String,
                  val issueCount: Int,
                  val dateOfBirth: Date)
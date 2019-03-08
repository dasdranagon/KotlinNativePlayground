package entities

import service.date.Date

class Person(val firstName: String,
             val surname: String,
             val issueCount: Int,
             val dateOfBirth: Date)
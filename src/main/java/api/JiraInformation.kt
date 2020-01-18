package api

data class JiraInformation(val identifer: String,
                           val title: String,
                           val description: String,
                           val assignee: String,
                           val reporter: String)
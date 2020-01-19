package api

data class AddComment(val body: String, val visiblity: CommentVisbility)

data class CommentVisbility(val type: String, val value: String)

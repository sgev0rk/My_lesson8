import com.google.gson.annotations.SerializedName

/*Fields (updatedAt and createdAt at https://cat-fact.herokuapp.com/facts) are ignored in CatInfo*/

data class CatInfo(
        @SerializedName("status")
        val status: Status? = null,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("deleted")
        val deleted: Boolean? = null,
        @SerializedName("_id")
        val _id: String? = null,
        @SerializedName("user")
        val user: String? = null,
        @SerializedName("text")
        val text: String? = null,
        @SerializedName("used")
        val used: Boolean? = null
)

data class Status(
        val verified: Boolean? = null,
        val sentCount: Int? = null,
        val feedback: String? = null
)
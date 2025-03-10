package dev.kord.rest.json.request

import dev.kord.common.Locale
import dev.kord.common.entity.*
import dev.kord.common.entity.optional.Optional
import dev.kord.common.entity.optional.OptionalBoolean
import dev.kord.rest.NamedFile
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApplicationCommandCreateRequest(
    val name: String,
    @SerialName("name_localizations")
    val nameLocalizations: Optional<Map<Locale, String>?> = Optional.Missing(),
    val type: ApplicationCommandType,
    val description: Optional<String> = Optional.Missing(),
    @SerialName("description_localizations")
    val descriptionLocalizations: Optional<Map<Locale, String>?> = Optional.Missing(),
    val options: Optional<List<ApplicationCommandOption>> = Optional.Missing(),
    @SerialName("default_member_permissions")
    public val defaultMemberPermissions: Optional<Permissions?> = Optional.Missing(),
    @Deprecated("'dmPermission' is deprecated in favor of 'contexts'. Setting 'dmPermission' to false can be replaced by setting 'contexts' to empty InteractionContextType. ('context' is only available for global commands.")
    @SerialName("dm_permission")
    public val dmPermission: OptionalBoolean? = OptionalBoolean.Missing,
    @Deprecated("'defaultPermission' is deprecated in favor of 'defaultMemberPermissions' and 'context'. Setting 'defaultPermission' to false can be replaced by setting 'defaultMemberPermissions' to empty Permission and 'context' to empty InteractionContextType ('context' is only available for global commands).")
    @SerialName("default_permission")
    val defaultPermission: OptionalBoolean = OptionalBoolean.Missing,
    val nsfw: OptionalBoolean = OptionalBoolean.Missing,
    val contexts: Optional<List<InteractionContextType>> = Optional.Missing()
)

@Serializable
public data class ApplicationCommandModifyRequest(
    val name: Optional<String> = Optional.Missing(),
    @SerialName("name_localizations")
    val nameLocalizations: Optional<Map<Locale, String>?> = Optional.Missing(),
    val description: Optional<String> = Optional.Missing(),
    @SerialName("description_localizations")
    val descriptionLocalizations: Optional<Map<Locale, String>?> = Optional.Missing(),
    val options: Optional<List<ApplicationCommandOption>> = Optional.Missing(),
    @SerialName("default_member_permissions")
    public val defaultMemberPermissions: Optional<Permissions?> = Optional.Missing(),
    @Deprecated("'dmPermission' is deprecated in favor of 'contexts'. Setting 'dmPermission' to false can be replaced by setting 'context' to empty InteractionContextType ('context' is only available to global commands).")
    @SerialName("dm_permission")
    public val dmPermission: OptionalBoolean? = OptionalBoolean.Missing,
    @Deprecated("'defaultPermission' is deprecated in favor of 'defaultMemberPermissions' and 'context'. Setting 'defaultPermission' to false can be replaced by setting 'defaultMemberPermissions' to empty Permission and 'context' to empty InteractionContextType ('context' is only available for global commands).")
    @SerialName("default_permission")
    val defaultPermission: OptionalBoolean = OptionalBoolean.Missing,
    val nsfw: OptionalBoolean = OptionalBoolean.Missing,
    val contexts: Optional<List<InteractionContextType>> = Optional.Missing()
)

@Serializable
public data class InteractionResponseModifyRequest(
    val content: Optional<String?> = Optional.Missing(),
    val embeds: Optional<List<EmbedRequest>?> = Optional.Missing(),
    @SerialName("allowed_mentions")
    val allowedMentions: Optional<AllowedMentions?> = Optional.Missing(),
    val flags: Optional<MessageFlags?> = Optional.Missing(),
    val components: Optional<List<DiscordComponent>?> = Optional.Missing(),
    val attachments: Optional<List<AttachmentRequest>?> = Optional.Missing(),
)

public data class MultipartInteractionResponseModifyRequest(
    val request: InteractionResponseModifyRequest,
    val files: List<NamedFile> = emptyList(),
)

@Serializable
public data class InteractionResponseCreateRequest(
    val type: InteractionResponseType,
    val data: Optional<InteractionApplicationCommandCallbackData> = Optional.Missing()
)

@Serializable
public data class AutoCompleteResponseCreateRequest(
    val type: InteractionResponseType,
    val data: DiscordAutoComplete,
)

@Serializable
public data class ModalResponseCreateRequest(
    val type: InteractionResponseType,
    val data: DiscordModal
)

public data class MultipartInteractionResponseCreateRequest(
    val request: InteractionResponseCreateRequest,
    val files: List<NamedFile> = emptyList(),
)

@Serializable
public data class InteractionApplicationCommandCallbackData(
    val tts: OptionalBoolean = OptionalBoolean.Missing,
    val content: Optional<String> = Optional.Missing(),
    val embeds: Optional<List<EmbedRequest>> = Optional.Missing(),
    @SerialName("allowed_mentions")
    val allowedMentions: Optional<AllowedMentions> = Optional.Missing(),
    val flags: Optional<MessageFlags> = Optional.Missing(),
    val components: Optional<List<DiscordComponent>> = Optional.Missing(),
    val attachments: Optional<List<AttachmentRequest>> = Optional.Missing(),
)

public data class MultipartFollowupMessageCreateRequest(
    val request: FollowupMessageCreateRequest,
    val files: List<NamedFile> = emptyList(),
)

@Serializable
public data class FollowupMessageCreateRequest(
    val content: Optional<String> = Optional.Missing(),
    val tts: OptionalBoolean = OptionalBoolean.Missing,
    val embeds: Optional<List<EmbedRequest>> = Optional.Missing(),
    @SerialName("allowed_mentions")
    val allowedMentions: Optional<AllowedMentions> = Optional.Missing(),
    val components: Optional<List<DiscordComponent>> = Optional.Missing(),
    val attachments: Optional<List<AttachmentRequest>> = Optional.Missing(),
    val flags: Optional<MessageFlags> = Optional.Missing(),
)

@Serializable
public data class FollowupMessageModifyRequest(
    val content: Optional<String?> = Optional.Missing(),
    val embeds: Optional<List<EmbedRequest>?> = Optional.Missing(),
    @SerialName("allowed_mentions")
    val allowedMentions: Optional<AllowedMentions?> = Optional.Missing(),
    val components: Optional<List<DiscordComponent>?> = Optional.Missing(),
    val attachments: Optional<List<AttachmentRequest>?> = Optional.Missing(),
    val flags: Optional<MessageFlags?> = Optional.Missing(),
)

public data class MultipartFollowupMessageModifyRequest(
    val request: FollowupMessageModifyRequest,
    val files: List<NamedFile> = emptyList(),
)

package dev.kord.core

import dev.kord.common.annotation.KordExperimental
import dev.kord.common.annotation.KordUnsafe
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.*
import dev.kord.core.behavior.channel.*
import dev.kord.core.behavior.channel.threads.PrivateThreadParentChannelBehavior
import dev.kord.core.behavior.channel.threads.ThreadChannelBehavior
import dev.kord.core.behavior.channel.threads.ThreadParentChannelBehavior
import dev.kord.core.behavior.interaction.ApplicationCommandInteractionBehavior
import dev.kord.core.behavior.interaction.ComponentInteractionBehavior
import dev.kord.core.entity.interaction.ApplicationCommandInteraction
import dev.kord.rest.service.InteractionService

/**
 * A class that exposes the creation of `{Entity}Behavior` classes.
 *
 * All functionality in this class *assumes* correct data is being passed along
 * and omits any requirements or checks. This makes using behaviors created by this
 * class inherently unsafe.
 *
 * If the user is not sure of the correctness of the data being passed along, it is advised
 * to use [Entities][dev.kord.core.entity.KordEntity] generated by [Kord] or other Entities instead.
 */
@KordUnsafe
@KordExperimental
@Suppress("EXPERIMENTAL_API_USAGE")
public class Unsafe(private val kord: Kord) {

    public fun message(channelId: Snowflake, messageId: Snowflake): MessageBehavior =
        MessageBehavior(channelId = channelId, messageId = messageId, kord = kord)

    public fun channel(id: Snowflake): ChannelBehavior =
        ChannelBehavior(id, kord)

    public fun messageChannel(id: Snowflake): MessageChannelBehavior =
        MessageChannelBehavior(id, kord)

    public fun topGuildChannel(guildId: Snowflake, id: Snowflake): TopGuildChannelBehavior =
        TopGuildChannelBehavior(guildId = guildId, id = id, kord = kord)

    public fun topGuildMessageChannel(guildId: Snowflake, id: Snowflake): TopGuildMessageChannelBehavior =
        TopGuildMessageChannelBehavior(guildId = guildId, id = id, kord = kord)

    public fun guildChannel(guildId: Snowflake, id: Snowflake): GuildChannelBehavior =
        GuildChannelBehavior(guildId, id, kord)

    public fun guildMessageChannel(guildId: Snowflake, id: Snowflake): GuildMessageChannelBehavior =
        GuildMessageChannelBehavior(guildId, id, kord)

    public fun newsChannel(guildId: Snowflake, id: Snowflake): NewsChannelBehavior =
        NewsChannelBehavior(guildId = guildId, id = id, kord = kord)

    public fun textChannel(guildId: Snowflake, id: Snowflake): TextChannelBehavior =
        TextChannelBehavior(guildId = guildId, id = id, kord = kord)

    public fun voiceChannel(guildId: Snowflake, id: Snowflake): VoiceChannelBehavior =
        VoiceChannelBehavior(guildId = guildId, id = id, kord = kord)

    public fun storeChannel(guildId: Snowflake, id: Snowflake): StoreChannelBehavior =
        StoreChannelBehavior(guildId = guildId, id = id, kord = kord)

    public fun publicThreadParent(guildId: Snowflake, id: Snowflake): ThreadParentChannelBehavior =
        ThreadParentChannelBehavior(guildId, id, kord)

    public fun privateThreadParent(guildId: Snowflake, id: Snowflake): PrivateThreadParentChannelBehavior =
        PrivateThreadParentChannelBehavior(guildId, id, kord)

    public fun thread(guildId: Snowflake, parentId: Snowflake, id: Snowflake): ThreadChannelBehavior =
        ThreadChannelBehavior(guildId, parentId, id, kord)


    public fun guild(id: Snowflake): GuildBehavior =
        GuildBehavior(id, kord)

    public fun guildEmoji(guildId: Snowflake, id: Snowflake, kord: Kord): GuildEmojiBehavior =
        GuildEmojiBehavior(guildId = guildId, id = id, kord = kord)

    public fun role(guildId: Snowflake, id: Snowflake): RoleBehavior =
        RoleBehavior(guildId = guildId, id = id, kord = kord)

    public fun user(id: Snowflake): UserBehavior =
        UserBehavior(id, kord)

    public fun threadMember(id: Snowflake, threadId: Snowflake): ThreadMemberBehavior =
        ThreadMemberBehavior(id, threadId, kord)

    public fun member(guildId: Snowflake, id: Snowflake): MemberBehavior =
        MemberBehavior(guildId = guildId, id = id, kord = kord)

    public fun webhook(id: Snowflake): WebhookBehavior =
        WebhookBehavior(id, kord)

    public fun stageInstance(id: Snowflake, channelId: Snowflake): StageInstanceBehavior = StageInstanceBehavior(
        id, channelId, kord, kord.defaultSupplier
    )

    public fun applicationCommandInteraction(
        id: Snowflake,
        channelId: Snowflake,
        token: String,
        applicationId: Snowflake
    ): ApplicationCommandInteractionBehavior {
        return ApplicationCommandInteractionBehavior(id, channelId, token, applicationId, kord)
    }


    public fun globalApplicationCommand(
        applicationId: Snowflake,
        id: Snowflake
    ): GlobalApplicationCommandBehavior {
        return GlobalApplicationCommandBehavior(applicationId, id, kord.rest.interaction)
    }


    public fun globalApplicationCommand(
        applicationId: Snowflake,
        guildId: Snowflake,
        id: Snowflake
    ): GuildApplicationCommandBehavior {
        return GuildApplicationCommandBehavior(guildId, applicationId, id, kord.rest.interaction)
    }


    override fun toString(): String {
        return "Unsafe"
    }

    public fun guildApplicationCommand(
        guildId: Snowflake,
        applicationId: Snowflake,
        commandId: Snowflake,
        service: InteractionService = kord.rest.interaction
    ): GuildApplicationCommandBehavior =
        GuildApplicationCommandBehavior(guildId, applicationId, commandId, service)

    public fun globalApplicationCommand(
        applicationId: Snowflake,
        commandId: Snowflake,
        service: InteractionService = kord.rest.interaction
    ): GlobalApplicationCommandBehavior =
        GlobalApplicationCommandBehavior(applicationId, commandId, service)

    /**
     * Creates a ComponentInteractionBehavior with the given [id], [channelId],
     * [token] and [applicationId].
     */
    public fun componentInteraction(
        id: Snowflake,
        channelId: Snowflake,
        token: String,
        applicationId: Snowflake = kord.selfId,
    ): ComponentInteractionBehavior = ComponentInteractionBehavior(
        id, channelId, token, applicationId, kord
    )

}

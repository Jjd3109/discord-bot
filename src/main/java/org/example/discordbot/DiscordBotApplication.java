package org.example.discordbot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class DiscordBotApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiscordBotApplication.class, args);

        DiscordBotToken discordBotTokenEntity = context.getBean(DiscordBotToken.class);
        String discordBotToken = discordBotTokenEntity.getDiscordBotToken();

        JDA jda = JDABuilder.createDefault(discordBotToken)
                .setActivity(Activity.playing("메뉴추천"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new DiscordListener())
                .build();
    }

    @Component
    public class DiscordBotToken {

        @Value("${discord.bot.token}")
        private String discordBotToken;

        public String getDiscordBotToken() {
            return discordBotToken;
        }
    }
}

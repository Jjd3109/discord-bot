package org.example.discordbot;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class DiscordListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        User user = event.getAuthor();
        TextChannel textChannel = event.getChannel().asTextChannel();
        Message message = event.getMessage();


        if (user.isBot()) {
            return;
        } else if (message.getContentDisplay().equals("")) {
            log.info("디스코드 Message 문자열 값 공백");
        }

        String[] messageArray = message.getContentDisplay().split(" ");

        if(message.getContentDisplay().equalsIgnoreCase("!점메추")){
            String returnMessage = sendOnlyMessage(event);
            textChannel.sendMessage(returnMessage).queue();
        }

        if (messageArray[0].equalsIgnoreCase("!점메추")) {
            String[] messageArgs = Arrays.copyOfRange(messageArray, 1, messageArray.length);

            for (String msg : messageArgs) {
                String returnMessage = sendMessage(event, msg);
                textChannel.sendMessage(returnMessage).queue();
            }
        }
    }

    /*
     * case 1. !점메추만
     */
    private String sendOnlyMessage(MessageReceivedEvent event) {

        String returnMessage = "";

        Random random = new Random();
        int value = 0; // 음식메뉴중에 고르는 value
        int choiceMenu = random.nextInt(4);

        switch (choiceMenu){
            case 0 :
                //일식

                value = random.nextInt(Japan.getMenus().length);
                Japan selectedJapan = Japan.getMenus()[value];

                returnMessage = selectedJapan.getDescription() + "ㄱㄱ";
                break;
            case 1:
                //한식
                value = random.nextInt(Korean.getMenus().length);
                Korean selectedKorean = Korean.getMenus()[value];

                returnMessage = selectedKorean.getDescription() + "ㄱㄱ";
                break;
            case 2:
                value = random.nextInt(Chinese.getMenus().length);
                Chinese selectedChinese = Chinese.getMenus()[value];

                returnMessage = selectedChinese.getDescription() + "ㄱㄱ";
                break;
            case 3:
                value = random.nextInt(American.getMenus().length);
                American selectdAmerican = American.getMenus()[value];

                returnMessage = selectdAmerican.getDescription() + "ㄱㄱ";
                break;
        }


        return returnMessage;
    }


    private String sendMessage(MessageReceivedEvent event, String message) {

        //전역변수 설정값
        String returnMessage = "";
        Random random = new Random();
        int value = 0;



        switch (message) {

            case "메뉴" :
                String[] menuList = {"일식", "중식", "양식", "한식"};
                value = random.nextInt(menuList.length);
                returnMessage = menuList[value] + "ㄱㄱ";
                break;

            case "한식" :
                value = random.nextInt(Korean.getMenus().length);
                Korean selectedKorean = Korean.getMenus()[value];

                returnMessage = selectedKorean.getDescription() + "ㄱㄱ";
                break;
            case "중식" :
                value = random.nextInt(Chinese.getMenus().length);
                Chinese selectedChinese = Chinese.getMenus()[value];

                returnMessage = selectedChinese.getDescription() + "ㄱㄱ";
                break;
            case "일식" :
                value = random.nextInt(Japan.getMenus().length);
                Japan selectedJapan = Japan.getMenus()[value];

                returnMessage = selectedJapan.getDescription() + "ㄱㄱ";
                break;
            case "양식" :
                value = random.nextInt(American.getMenus().length);
                American selectdAmerican = American.getMenus()[value];

                returnMessage = selectdAmerican.getDescription() + "ㄱㄱ";
                break;
            default: returnMessage = "[!점메추 한식] 이런식으로 ㄱㄱ";
                break;
        }
        return returnMessage;
    }
}
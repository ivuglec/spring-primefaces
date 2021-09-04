package com.ivuglec2.springprimefaces.config;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.events.ChannelChangeGameEvent;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import com.github.twitch4j.events.ChannelGoOfflineEvent;
import com.github.twitch4j.helix.domain.UserList;
import com.ivuglec2.springprimefaces.service.BrowserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TwitchClientInit implements InitializingBean {

    final BrowserService browserService;
    public TwitchClientInit(BrowserService browserService) {
        this.browserService = browserService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TwitchClientInit ...");
        TwitchClient twitchClient = TwitchClientBuilder.builder()
//                .withDefaultAuthToken(new OAuth2Credential("twitch", "hwftai9tdpvr7fsf1k01pyuk407lxc"))
                .withClientId("9nbbxky11q04ibl2blummmiyeghjns")
                .withClientSecret("qdr7bx7qtel3o21alccfgn3q8wf2xj")
                .withEnableHelix(true)
                .withEnableKraken(true)
                .build();

//        flambass
        twitchClient.getClientHelper().enableStreamEventListener("worldofwarships");

//        twitchClient.getClientHelper().enableStreamEventListener("flambass");

        twitchClient.getEventManager().onEvent(ChannelGoLiveEvent.class, event -> {
            //[worldofwarships] went live with title [CZ] Žabákovy kvákterky: Temný Černěnec s Bl4ckSK! on game World of Warships!
            System.out.println("[" + event.getChannel().getName() + "] went live with title " + event.getStream().getTitle() + " on game " + event.getStream().getGameName() + "!");
        });

        twitchClient.getEventManager().onEvent(ChannelGoOfflineEvent.class, event -> {
            System.out.println("[" + event.getChannel().getName() + "] just went offline!");
        });

        twitchClient.getEventManager().onEvent(ChannelChangeGameEvent.class, event -> {
            System.out.println("[" + event.getChannel().getName() + "] is now playing " + event.getGameId() + "!");
        });
    }
}

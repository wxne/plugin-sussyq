package pl.tripmc.testerplugin.controller;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SkinController {

    public static void isChangeSkin(Player player) {
        PlayerProfile playerProfile = player.getPlayerProfile();
        String targetName = "SussyQ";
        try {
            URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + targetName);

            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());

            String uuid = JsonParser.parseReader(inputStreamReader).getAsJsonObject().get("id").getAsString();

            URL url1 = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");

            InputStreamReader inputStreamReader1 = new InputStreamReader(url1.openStream());

            JsonObject properties = JsonParser.parseReader(inputStreamReader1).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();

            String value = properties.get("value").getAsString();
            String signature = properties.get("signature").getAsString();

            playerProfile.setProperty(new ProfileProperty("textures", value, signature));
            player.setPlayerProfile(playerProfile);

            player.sendMessage("zmieniono ");

        } catch (IllegalStateException | IOException | NullPointerException exception) {
            player.sendMessage("cos poszlo nie tak");
        }
    }
}

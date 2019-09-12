package com.ludovic.utils;

import com.ludovic.Main;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toRadians;

public class Utils {
    private static final List<String> colors = new ArrayList<String>() {
        {
            add("white");
            add("silver");
            add("gray");
            add("black");
            add("red");
            add("maroon");
            add("yellow");
            add("olive");
            add("lime");
            add("green");
            add("aqua");
            add("teal");
            add("blue");
            add("navy");
            add("fuchsia");
            add("purple");
            add("orange");
        }
    };

    public static Color translateColor(String name) {
        switch (name) {
            case "SILVER":
                return Color.SILVER;

            case "GRAY":
                return Color.GRAY;

            case "BLACK":
                return Color.BLACK;

            case "RED":
                return Color.RED;

            case "MAROON":
                return Color.MAROON;

            case "YELLOW":
                return Color.YELLOW;

            case "OLIVE":
                return Color.OLIVE;

            case "LIME":
                return Color.LIME;

            case "GREEN":
                return Color.GREEN;

            case "AQUA":
                return Color.AQUA;

            case "TEAL":
                return Color.TEAL;

            case "BLUE":
                return Color.BLUE;

            case "NAVY":
                return Color.NAVY;

            case "FUCHSIA":
                return Color.FUCHSIA;

            case "PURPLE":
                return Color.PURPLE;

            case "ORANGE":
                return Color.ORANGE;
            default:
                return Color.WHITE;
        }
    }

    public static List<String> getColors() {
        return colors;
    }


    public static void createArmorStand(Player player, Location location, String name, Color color) {
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        helmetMeta.setColor(color);
        helmet.setItemMeta(helmetMeta);

        ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestPlate.getItemMeta();
        chestplateMeta.setColor(color);
        chestPlate.setItemMeta(chestplateMeta);

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leggingsMeta.setColor(color);
        leggings.setItemMeta(leggingsMeta);

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        boots.setItemMeta(bootsMeta);

        ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(location.add(0.5,1, 0.5), EntityType.ARMOR_STAND);
        stand.setVisible(true);
        stand.setArms(true);
        stand.setHelmet(helmet);
        stand.setChestplate(chestPlate);
        stand.setLeggings(leggings);
        stand.setBoots(boots);
        stand.setGravity(false);
        stand.setCustomNameVisible(true);
        stand.setCustomName(name);
        stand.setBasePlate(false);
    }

    public static void spawnRange(Player player, Block block) {
        String uuid = player.getUniqueId().toString();
        String value = Main.spellZone.get(uuid);

        char type = value.charAt(0);
        int range = Integer.parseInt(String.valueOf(value.charAt(1))) + 1;

        if (type == 's') {
            int x = 0;
            int z = 0;
            for (int i=0; i<360; i++) {
                x = (int) (range * Math.sin(toRadians(i)));
                z = (int) (range * Math.cos(toRadians(i)));

                block.getRelative(x, 1, z).setType(Material.WHITE_CARPET);
            }

            block.getRelative(range, 1, 0).setType(Material.AIR);
            block.getRelative(-range, 1,0).setType(Material.AIR);
            block.getRelative(0, 1, range).setType(Material.AIR);
            block.getRelative(0, 1, -range).setType(Material.AIR);

        }

    }
}

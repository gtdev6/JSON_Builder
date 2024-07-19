package model;

import model.Moves.LevelUpMove;

import java.util.ArrayList;

public class model {
    public static PrototypeJSON data = new PrototypeJSON();
    public static boolean openFile;
    public static Form newForm;
    public static boolean isEditing = false;
    public static int indexOfEditingForm = -1;
    public static int selectedGP = -1;

    public static int indexOfSelectedEvolution = -1;

    public static void initializeForm() {
        newForm = new Form();
    }

    public static Form getNewForm() {
        return newForm;
    }

    public static LevelUpMove levelUpMoveParser(String str) {
        if (str.isEmpty())
            return null;
        ArrayList<String> attacks = new ArrayList<>();
        int level = Integer.parseInt(str.substring(7, str.indexOf(",")));
        String[] results = str.split("=");
        String chanti = results[2].replaceAll("\\[|\\]", "");
        if (!chanti.isBlank()) {
            String[] chanti3 = chanti.split(",");
            for (int i = 0; i < chanti3.length; i++) {
                chanti3[i] = chanti3[i].trim();
                attacks.add(chanti3[i]);
            }
        }
        LevelUpMove lup = new LevelUpMove();
        lup.setLevel(level);
        lup.setAttacks(attacks);
        System.out.println(lup.toString());
        return lup;
    }

}

class ResistorColor {
    int colorCode(String color) {
        String[] cores = colors();
        for(int code = 0; code<cores.length ; code++)
            if (color.equals(cores[code]))
                return code;
        return 0;
    }

    String[] colors() {
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        return colors;
    }
}

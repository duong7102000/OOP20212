package Util;

public class NormalizeString {
    public static String normalizeSearchString(String string){
        string = string.replaceAll(" ", "");
        string = string.toLowerCase();
        string = VNCharacterUtils.removeAccent(string);
        return string;
    }
}
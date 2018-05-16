import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CapitalizeTest {

    @Test
    public void capitalizeByWords() {
        assertEquals("Fulano Da Silva Sauro", Capitalize.capitalizeByWords("FULANO DA SILVA SAURO"));
    }

    @Test
    public void brazilianCapitalize() {
        assertEquals("Fulano da Silva Sauro de Moura",
                Capitalize.brazilianCapitalize("FULANO DA SILVA SAURO de moura"));
    }

    @Test
    public void toPascalCase() {
        assertEquals("FulanoDaSilvaSauroDeMoura",
                Capitalize.toPascalCase("FULANO DA SILVA SAURO de moura"));
    }

    @Test
    public void toCamelCase() {
        assertEquals("fulanoDaSilvaSauroDeMoura",
                Capitalize.toCamelCase("FULANO DA SILVA SAURO de moura"));
    }

    @Test
    public void toSneakCase() {
        assertEquals("fulano_da_silva_sauro_de_moura",
                Capitalize.toSneakCase("FULANO DA SILVA SAURO de moura"));
    }

    @Test
    public void toSlugCase() {
        assertEquals("fulano-da-silva-sauro-de-moura",
                Capitalize.toSlugCase("FULANO DA SILVA SAURO de moura"));
    }

    @Test
    public void testWithFilenameSneak(){
        assertEquals("file_music.mp3",
                Capitalize.toSneakCase("file music.mp3"));
    }

    @Test
    public void testWithFilenameSlug(){
        assertEquals("file-music.mp3",
                Capitalize.toSlugCase("file music.mp3"));
    }

    @Test
    public void testWithFilenameCamel(){
        assertEquals("FileMusic.mp3",
                Capitalize.toPascalCase("file music.mp3"));
    }
}
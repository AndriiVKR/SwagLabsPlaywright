package setup;

import com.microsoft.playwright.CLI;

import java.io.IOException;

public class BrowserInstaller {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            CLI.main(new String[]{"install"});
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

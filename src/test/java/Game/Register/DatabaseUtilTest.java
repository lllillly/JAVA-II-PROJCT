package Game.Register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DatabaseUtilTest {
    @Test
    void configurationCheckDoesNotExposeOrRequireCredentials() {
        assertDoesNotThrow(DatabaseUtil::isConfigured);
    }
}

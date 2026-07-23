package Game.Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseUtil {
    private static final String URL_ENV = "GAME_DB_URL";
    private static final String USER_ENV = "GAME_DB_USER";
    private static final String PASSWORD_ENV = "GAME_DB_PASSWORD";

    private DatabaseUtil() {
    }

    public static boolean isConfigured() {
        return hasText(System.getenv(URL_ENV))
            && hasText(System.getenv(USER_ENV))
            && hasText(System.getenv(PASSWORD_ENV));
    }

    public static Connection getConnection() throws SQLException {
        if (!isConfigured()) {
            throw new SQLException(
                "DB 환경변수가 없습니다. 포트폴리오 시연은 시작 화면의 게스트 모드를 이용하세요."
            );
        }

        return DriverManager.getConnection(
            System.getenv(URL_ENV),
            System.getenv(USER_ENV),
            System.getenv(PASSWORD_ENV)
        );
    }

    private static boolean hasText(String value) {
        return value != null && !value.isBlank();
    }
}

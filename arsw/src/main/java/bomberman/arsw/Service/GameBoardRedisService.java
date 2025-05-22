package bomberman.arsw.Service;

import bomberman.arsw.Model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class GameBoardRedisService {

    @Autowired
    private RedisTemplate<String, GameBoard> gameBoardRedisTemplate;

    public void saveBoard(String roomCode, GameBoard board) {
        gameBoardRedisTemplate.opsForValue().set("board:" + roomCode, board);
    }

    public GameBoard getBoard(String roomCode) {
        return gameBoardRedisTemplate.opsForValue().get("board:" + roomCode);
    }

    public boolean boardExists(String roomCode) {
        return Boolean.TRUE.equals(gameBoardRedisTemplate.hasKey("board:" + roomCode));
    }

    public void deleteBoard(String roomCode) {
        gameBoardRedisTemplate.delete("board:" + roomCode);
    }
}

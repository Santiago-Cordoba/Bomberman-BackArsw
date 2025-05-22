package bomberman.arsw.Service;

import bomberman.arsw.Model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RoomRedisService {

    @Autowired
    private RedisTemplate<String, Room> roomRedisTemplate;

    public void saveRoom(String roomCode, Room room) {
        roomRedisTemplate.opsForValue().set("room:" + roomCode, room);
    }

    public Room getRoom(String roomCode) {
        return roomRedisTemplate.opsForValue().get("room:" + roomCode);
    }

    public boolean roomExists(String roomCode) {
        return Boolean.TRUE.equals(roomRedisTemplate.hasKey("room:" + roomCode));
    }

    public void deleteRoom(String roomCode) {
        roomRedisTemplate.delete("room:" + roomCode);
    }
}

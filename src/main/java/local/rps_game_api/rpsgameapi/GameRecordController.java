package local.rps_game_api.rpsgameapi;

import local.rps_game_api.rpsgameapi.model.GameRecord;
import local.rps_game_api.rpsgameapi.repository.GameDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game-records")
public class GameRecordController {

    @Autowired
    private GameDataRepo gameRecordRepository;

    @PostMapping("/add")
    public GameRecord createGameRecord(@RequestBody GameRecord gameRecord) {
        return gameRecordRepository.save(gameRecord);
    }

    @GetMapping("/all")
    public List<GameRecord> getAllGameRecords() {
        Sort  sort = Sort.by(Sort.Direction.DESC, "highScore");
        Pageable pageable = PageRequest.of(0, 20, sort);
        return gameRecordRepository.findAll(pageable).getContent();
    }

}
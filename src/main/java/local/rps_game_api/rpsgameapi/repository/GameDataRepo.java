package local.rps_game_api.rpsgameapi.repository;

import local.rps_game_api.rpsgameapi.model.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDataRepo extends JpaRepository<GameRecord, Long> {
}



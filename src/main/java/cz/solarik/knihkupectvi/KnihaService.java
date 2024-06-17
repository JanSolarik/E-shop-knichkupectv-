package cz.solarik.knihkupectvi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnihaService {
    @Autowired
    private KnihaRepository knihaRepository;

    public void deleteKniha(Long id) {
        knihaRepository.deleteById(id);
    }
}

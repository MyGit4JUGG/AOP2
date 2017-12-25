package beans;

import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
	
	public void saveObject(Object entity) {
		System.out.println("saveObject");
		throw new RuntimeException("runtimeException");
	}
	public void updateObject(Object entity) {
		System.out.println("updateObject");
	}

}

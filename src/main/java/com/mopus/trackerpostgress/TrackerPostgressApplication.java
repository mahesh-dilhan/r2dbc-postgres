package com.mopus.trackerpostgress;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.*;

@SpringBootApplication
public class TrackerPostgressApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerPostgressApplication.class, args);
	}

}

interface TrackerRepository extends ReactiveCrudRepository<Traker,Integer>{

}

@Log4j2
@Component
class DataLoader {
	private final TrackerRepository trackerRepository;

	DataLoader(TrackerRepository trackerRepository) {
		this.trackerRepository = trackerRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void write(){
		List<Traker> lst= new ArrayList<>();

		for(int i=0;i<10;i++) {

			Traker t = Traker.builder()
					//.trakerId(UUID.randomUUID().toString())
					.subscriptionId(UUID.randomUUID().toString())
					.appId(UUID.randomUUID().toString())
					.deviceId(UUID.randomUUID().toString())
					.messageIdentifer(UUID.randomUUID().toString())
					.status("NEW")
					.body(UUID.randomUUID().toString())
					.title(UUID.randomUUID().toString())
					.isMutable(1)
					.emailId(UUID.randomUUID().toString())
					.recepientId(UUID.randomUUID().toString())
					.userId(UUID.randomUUID().toString())
					.dl(UUID.randomUUID().toString())
					.url(UUID.randomUUID().toString())
					.createTimeStamp(new Date())
					.lastUpdatedTimestamp(new Date())
					.build();
			lst.add(t);
		}

		log.info("{}",lst.size());
		this.trackerRepository.saveAll(Flux.fromIterable(lst)).subscribe();
	}
}
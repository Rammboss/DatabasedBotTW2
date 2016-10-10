package com.bot.common.auftraege;

import java.util.concurrent.TimeUnit;

import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;
import com.bot.settings.Utils;
import com.database.configuration.AppConfig;
import com.database.model.Analyser;
import com.database.model.Dorf;
import com.database.service.AnalyserService;
import com.database.service.DorfService;

public class NothingToDo extends Auftrag{

	public Analyser analyser;
	private final int RECHTS = 1;
	private final int HOCH = 2;
	private final int LINKS = 3;
	private final int RUNTER = 4;
	private int counter;
	private int richtung;
	private MouseRobot robot;

	private boolean timeout;

	private int breite;

	public NothingToDo(int p) {
		super(p);
		robot = new MouseRobot(Utils.HWND);
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		AnalyserService service = (AnalyserService) context.getBean("analyserService");

		analyser = service.findById(1);
		context.close();
		this.breite = analyser.getBreite();
		this.setCounter(analyser.getRichtungscounter());
		this.setRichtung(analyser.getRichtung());

	}

	public void anelyseMapCircle() {

		int X = analyser.getX();
		int Y = analyser.getY();
		for (; breite < 100; breite += 2) {
			if (timeout) {
				System.out.println("Ende --> For Schleife 1");
				break;
			}
			for (int j = richtung; j < 5; j++) { // 4 Richtungen
				if (timeout) {
					System.out.println("Ende --> For Schleife 2");
					break;
				}
				switch (richtung) {
				case RECHTS: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						X += 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							System.out.println("Ende --> For Schleife Case");
							break;
						}

					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = HOCH;
					}

				}
					break;
				case LINKS: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						X -= 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							System.out.println("Ende --> For Schleife Case");
							break;
						}
					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = RUNTER;

					}

				}
					break;
				case HOCH: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						Y -= 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							System.out.println("Ende --> For Schleife Case");
							break;
						}
					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = LINKS;
					}
				}
					break;
				case RUNTER: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						Y += 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							System.out.println("Ende --> For Schleife Case");
							break;
						}
					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = RECHTS;
					}
				}
					break;

				}
			}

		}
	}
	@Override
	public void run(MouseRobot robot) {

		anelyseMapCircle();

		int X = analyser.getX();
		int Y = analyser.getY();
		for (; breite < 100; breite += 2) {
			if (timeout) {
				break;
			}
			for (int j = richtung; j < 5; j++) { // 4 Richtungen
				if (timeout) {
					break;
				}
				switch (richtung) {
				case RECHTS: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						X += 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							break;
						}

					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = HOCH;
					}

				}
					break;
				case LINKS: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						X -= 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							break;
						}
					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = RUNTER;

					}

				}
					break;
				case HOCH: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						Y -= 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							break;
						}
					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = LINKS;
					}
				}
					break;
				case RUNTER: {
					for (int i = counter; i < breite + 1; i++) {
						counter++;
						Y += 1;
						if (checkField(X, Y)) {
							// save(X, Y);
						}

						if (timeout && counter != breite + 1) {
							break;
						}
					}
					if (!timeout || counter == breite + 1) {
						counter = 0;
						richtung = RECHTS;
					}
				}
					break;

				}
			}

			if (!timeout) {
				Y += 1;
				X -= 1;
			}
		}
	}

	private void save(int x, int y) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		AnalyserService service = (AnalyserService) context.getBean("analyserService");

		analyser.setBreite(breite);
		analyser.setRichtung(richtung);
		analyser.setRichtungscounter(counter);
		analyser.setX(x);
		analyser.setY(y);
		service.updateAnalyser(analyser);
		context.close();
	}

	private boolean checkField(int x, int y) {

		System.out.println("Checking Field " + x + "|" + y);
		// MouseRobot.wait(200);
		new OpenSeachOnMap(0).run(robot);
		new EnterKoordinaten(0, x, y).run(robot);

		Dorf d = new Dorf(x, y, "Babarendorf", new LocalDateTime());

		//isSelected();
		if (Buttons.CHECKBARBARENDORF.check()) {
			save(x, y);
			// Hier dorf speichern in Datenbank
			AbstractApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
			DorfService service2 = (DorfService) context2.getBean("dorfService");
			service2.saveDorf(d);
			context2.close();
			// Ende
			System.out.println("Speichere dorf " + d);
			return true;
		}

		timeout = true;
		return false;
	}

	private boolean isSelected() {

		boolean run = true;
		int counter = 0;
		while (run) {
			if (Buttons.IS_SELECTED.IsActive(200) || counter > 10) {
				run = false;
				if (counter > 10)
					return false;
				return true;
			}
			counter++;
			MouseRobot.wait(25, TimeUnit.MILLISECONDS);

		}
		return false;

	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getRichtung() {
		return richtung;
	}

	public void setRichtung(int richtung) {
		this.richtung = richtung;
	}





}

public class RabbitAndTurtle {
        public static void main(String[] args) {
            AnimalThread turtle = (new AnimalThread("Черепаха", 1));
            AnimalThread rabbit = (new AnimalThread("Кролик",3));
            turtle.start();
            rabbit.start();
        }
    }
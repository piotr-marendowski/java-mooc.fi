public class HealthStation {
    /* part 1 */
    public int weigh(Person person) {
        weighings++;
        return person.getWeight();
    }

    /* part 2 */
    public void feed(Person person) {
        person.setWeight(person.getWeight() + 1);
    }

    /* part 3 */
    private int weighings;

    public HealthStation() {
        this.weighings = 0;
    }

    public int weighings() {
        return weighings;
    }
    
    public static void main(String[] args) {
        HealthStation childrensHospital = new HealthStation();

        Person ethan = new Person("Ethan", 1, 110, 7);
        Person peter = new Person("Peter", 33, 176, 85);

        System.out.println("weighings performed: " + childrensHospital.weighings());

        childrensHospital.weigh(ethan);
        childrensHospital.weigh(peter);

        System.out.println("weighings performed: " + childrensHospital.weighings());

        childrensHospital.weigh(ethan);
        childrensHospital.weigh(ethan);
        childrensHospital.weigh(ethan);
        childrensHospital.weigh(ethan);

        System.out.println("weighings performed: " + childrensHospital.weighings());   
    }
}

package models;

public class DnaTest implements Comparable<DnaTest> {

    int testId;
    int userId;
    String name;
    String gen1;
    String gen2;
    String gen3;
    String gen4;
    int fatherId;

    public DnaTest() {
        testId=hashCode();
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGen1() {
        return gen1;
    }

    public void setGen1(String gen1) {
        this.gen1 = gen1;
    }

    public String getGen2() {
        return gen2;
    }

    public void setGen2(String gen2) {
        this.gen2 = gen2;
    }

    public String getGen3() {
        return gen3;
    }

    public void setGen3(String gen3) {
        this.gen3 = gen3;
    }

    public String getGen4() {
        return gen4;
    }

    public void setGen4(String gen4) {
        this.gen4 = gen4;
    }

    public int getFatherId() {
        return fatherId;
    }

    public void setFatherId(int fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public int compareTo(DnaTest test) {
        DnaTest t = (DnaTest) test;
        int pb = test.userId;
        return pb;
        
    }

 
    
}

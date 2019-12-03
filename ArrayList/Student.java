public class Student {

private String lastName;

private int testScore;

public Student(String name, int score) {

lastName = name;

testScore = score;

}

public void setScore(int score){

testScore = score;
}

public int getScore(){
return testScore;
}

public void setName(String name){
lastName = name;
}

public String getName() {

return lastName;
}
}






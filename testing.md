    private String name;
    private int age;
    private  ArrayList<String> borrowedBooks;
    private  Map<String, LocalDate> borrowedBooksDueDates;
    

    public User(String name, int age){
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooksDueDates = new HashMap<>() {
            
        };
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
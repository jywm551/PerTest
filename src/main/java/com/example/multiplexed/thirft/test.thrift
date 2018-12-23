namespace java com.server
struct Topic{
  1: i32 uid
  2: string name
  3: string content
}

struct User{
    1: i32 uid
    2: string name;
    3: string blurb
}

service TopicService{
    void store(1: Topic topic)
    Topic retrieve(1: i32 uid)
}


service UserService{
  void store1(1: User user)
  User retrieve1(1: i32 uid)
}
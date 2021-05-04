import groovy.json.*
  
class person { String name; String cell; }
class user {
  String company;
  person[] persons;
}

def persons = [
  new person(name:'gd', cell:'01022223333'),
  new person(name:'hy', cell:'01011112222')
]

def auser = new user()
auser.company = 'banana'
auser.persons = persons

builder = new JsonBuilder(auser)
json = builder.toPrettyString()
print(json)

// 실행결과
// {
//   "company":"banana",
//   "persons": [
//      {
//        "cell":"01011112222",
//        "name":"gd"
//      },
//      {
//        "cell":"01011112222",
//        "name":"hy"
//      }
//   ] 
// }

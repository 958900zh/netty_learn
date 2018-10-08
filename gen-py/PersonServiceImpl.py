from py.thrift.generated import ttypes


class PersonServiceImpl:

    def getPersonByUsername(self, username):
        print("Python Server Got client param" + username)

        person = ttypes.Person()
        person.username = username
        person.age = 21
        person.married = False

        return person

    def savePerson(self, person):
        print("Python Server Got client param")

        print(person.username)
        print(person.age)
        print(person.married)

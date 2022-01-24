import './App.css';
import MenuUsers from "./component/MenuUsers"
import FormAddUser from "./component/FormAddUser";
import {useState} from "react";

function App() {
    const [users, setUsers] = useState(null)



  return (
    <div className="App">
      <MenuUsers setUsers={setUsers} users={users}></MenuUsers>
      <FormAddUser setUsers={setUsers} users={users}></FormAddUser>
    </div>
  );
}



export default App;

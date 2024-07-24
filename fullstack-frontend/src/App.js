
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import HomeMain from './pages/HomeMain';
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';
import AddUser from './users/AddUser';
import EditUser from './users/EditUser';
import ViewUser from './users/ViewUser';


function App() {
  return (
    <div className="App">
      <Router>
      <Navbar/>

      <Routes>
        <Route exact path ="/" element={<HomeMain/>}></Route>
        <Route exact path ="/addUser" element={<AddUser/>}></Route>
        <Route exact path ="/edituser/:id" element={<EditUser/>}></Route>
        <Route exact path ="/viewuser/:id" element={<ViewUser/>}></Route>
      </Routes>
     
      </Router>
      
    </div>
  );
}

export default App;

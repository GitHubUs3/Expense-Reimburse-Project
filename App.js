import logo from './logo.svg';
import './App.css';
import { ListForm } from './components/Expense/ListForm';
import { ExpenseForm } from './components/Expense/NewForm';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { NavBar } from './components/NavBar';

function App() {
  return (
    <BrowserRouter>
      <NavBar/>
      <Routes>
        <Route path="/" element={<ListForm/>}/>
        <Route path="/addForm" element={<ExpenseForm/>}/>

      </Routes>
    </BrowserRouter>
  );
}

export default App;

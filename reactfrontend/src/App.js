import { useState, useEffect } from "react";
import "./App.css";
import { Button, Alert } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import Navs from "./components/Navs";
import Cards from "./components/Cards";
import axios from "axios";

function App() {
  const [data, setData] = useState([]);

  const getData = async () => {
    const resposne = await axios
      .get(`http://localhost:8080/book/all-books`)
      .catch((err) => console.log("Error", err));
    setData(resposne.data);
  };

  useEffect(() => {
    getData();
  }, []);
  return (
    <div>
      <Navs ></Navs>
      <Cards data={data}></Cards>
    </div>
  );
}

export default App;

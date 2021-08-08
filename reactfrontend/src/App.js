import { useState, useEffect } from "react";
import "./App.css";
import { Button, Alert } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import Navs from "./components/Navs";
import Cards from "./components/Cards";
import axios from "axios";
import Pagination from "./components/Pagination";

function App() {
  const [data, setData] = useState([]);
  const [page, setPage] = useState(0);
  const [pageSize, setPageSize] = useState(4);

  const getDataBypage = async () => {
    const resposne = await axios
      .get(
        `http://localhost:8080/book/book-by-page?page=${page}&size=${pageSize}`
      )
      .catch((err) => console.log("Error", err));
    setData(resposne.data.books);
    console.log(resposne);
  };

  const capture = (e) => {
    setPage(e.target.outerText -1);
    console.log(e.target.outerText);
  };
  useEffect(
    (page, pageSize) => {
      getDataBypage();
    },
    [page, pageSize]
  );
  return (
    <div>
      <Navs></Navs>
      <Cards data={data}></Cards>
      <Pagination capture={capture}></Pagination>
    </div>
  );
}

export default App;

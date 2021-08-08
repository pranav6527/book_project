import React from "react";
import { Container,Navbar,Nav,Form,FormControl,Button } from "react-bootstrap";

const Navs = () => {
  return(
  <Navbar sticky="top"  bg="dark" variant="dark">
  <Container fluid>
  <Navbar.Brand href="#home">Book Store</Navbar.Brand>
  <Nav className=" d-flex justify-content-end">
  <Form className="d-flex ">
      <FormControl
        type="search"
        placeholder="Search"
        className=""
        aria-label="Search"
      />
      <Button variant="outline-success">Search</Button>
    </Form>
    <Nav.Link href="#features">Add Books</Nav.Link>
    <Nav.Link href="#pricing">Logout</Nav.Link>
  </Nav>
  </Container>
</Navbar>)
};
  
export default Navs;

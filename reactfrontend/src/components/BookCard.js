import { React } from "react";
import { Card, Badge, Button } from "react-bootstrap";
import book from "../assets/book.jpg";

const BookCard = ({ data }) => {
  return (
    <div>
      <Card className="m-2" style={{ width: "18rem" }}>
        <Card.Img variant="top" src={book} />
        <Card.Body>
          <Card.Title >{data.book_name}</Card.Title>
          <blockquote className="d-flex justify-content-end blockquote">
            <footer className="blockquote-footer ">
               <cite title="Source Title">{data.author}</cite>
            </footer>
          </blockquote>
        </Card.Body>
        <Card.Body className="d-flex justify-content-between">
          <Button variant="primary">
           Price : <i class="fa fa-inr">&nbsp;{data.price}</i>
           
          </Button>
          <Button variant="success">
            <Badge bg="primary">Buy</Badge>
           
          </Button>
        </Card.Body>
      </Card>
    </div>
  );
};

export default BookCard;

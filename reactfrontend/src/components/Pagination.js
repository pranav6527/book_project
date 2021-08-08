import { React, useState } from "react";
import { ButtonToolbar, ButtonGroup, Button } from "react-bootstrap";
const Pagination = ({ capture }) => {
  const [buttons, setButtons] = useState([1, 2, 3, 4, 5,6]);
  console.log(buttons.map((button) => button));

  return (
    <div className="d-flex justify-content-end align-self-end">
      {buttons.map((button) => {
        return (
          <Button key={button} onClick={capture} variant="outline-danger">
            {button}
          </Button>
        );
      })}
    </div>
  );
};

export default Pagination;

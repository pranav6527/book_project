import { useState } from "react";

import { Alert,Button} from "react-bootstrap";

const AlertState = () => {
  const [show, setShow] = useState(true);
  return (
    <div >
      <Alert show={show}  variant="success" >This is alert
      <Alert.Heading >How's it going?!</Alert.Heading>
      <p>
         I am Pranav
        </p>
        <hr />
        <div className='d-flex justify-content-end'>
            <Button onClick={()=>setShow(false)}  variant="outline-success" > close </Button>
        </div>
      </Alert>
      {!show && <Button onClick={()=>setShow(true)} >Show Alert</Button>}
    </div>
  );
};

export default AlertState;

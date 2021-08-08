import React from 'react'
import BookCard  from './BookCard'
const Cards = ({data}) => {
    return (
        <div className="d-flex justify-content-between flex-wrap">
          {data &&  data.map(data=><BookCard key={data.id} data={data}></BookCard>)}
        </div>
    )
}

export default Cards

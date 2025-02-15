import { useEffect } from 'react';
import './AddTable.css'

export default function SelectTable({title, fields, list, closeTable}) {

  useEffect(() => {
  }, [])

  const checkField = () => {

  }

  return (
    <form>
      <button className='close-x' onClick={closeTable}>x</button>
      <p className='title'>{title}</p>
      {fields && fields.map((field, index) => (
        field.action === "fill" ?
          <div className='form-input'>
            <label style={{width: "200px"}} for={field.name}>{field.name}</label>
            <input type="text" id={field.name} name={field.name} />
            <p></p>
          </div>
        :
          <div className='form-input'>
            <p>{field.name}</p>
            <div className='radios'>
              {["hotel1","hotel3","hotel2"] && ["hotel1","hotel3","hotel2"].map((item) => (
                <div>
                  <label className='radio-label' for={item}>{item}</label>
                  <input className='radio-button' type="radio" id={item} name={"list"+index} value={item} />
                </div>
              ))}
            </div>
          </div>
      ))}
    </form>
  );
}
CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  names TEXT[] NOT NULL,
  checked BOOLEAN DEFAULT FALSE
);

INSERT INTO products (names) VALUES (
  '{B. Kamins Purifying Toner,B. Kamins Purifying Toner-6 oz.,B. Kamins Hydrogen-ion Moisturizing Toner oily skin 8.oz,B. Kamins Chemist - Purifying Toner,B Kamins Purifying Toner 6oz}'
);

INSERT INTO products (names) VALUES (
  '{Vichy Purete Thermale Perfecting Toner 200ml,Vichy Purete Thermale Perfecting Toner (200ml),Vichy Purete Thermale Perfecting Toner - For Sensitive Skin 200ml/6.7oz,Vichy Laboratoires Purete Thermale Perfecting Toner,Purete Thermale Perfecting Toner,Vichy Purete Thermal Refreshing Toner,Vichy Laboratoires Purete Thermale Perfecting Toner,6.76 oz,Vichy Purete Thermale Perfecting Toner 6.76 oz,Vichy Purete Thermale Perfecting Toner 200ml Genuine &,Vichy Laboratories Purete Thermale Perfecting Toner 6.8 oz,Vichy Laboratories Purete Thermale Perfecting Toner 6.8 Oz}'
);

INSERT INTO products (names) VALUES (
  '{iS Clinical Firming Complex,IS Clinical Firming Complex,1.7 Ounce,Is Clinical Firming Complex 1.7 Oz. - In Box,iS Clinical Facial Moisturizing Lotion 1.7 oz (CL1201-050),iS Clinical Firming Complex,1.7 oz,Is Clinical Firming Complex 50ml,Firming Complex by IS Clinical - 12355014401,Is Clinical Firming Complex,1.7 Ounce,IS Clinical Firming Complex 50ml/1.7oz,Firming Complex By Is Clinical - 12355014401,Is Clinical 12355014401 Firming Complex - 50ml-1.7oz,Firming Complex}'
);

INSERT INTO products (names) VALUES (
  '{YonKa Nutri Contour,Yonka Nutri Contour 0.5oz/15ml W/o Box,Yonka Nutri-Contour Eyes & Lips Repairing Creme,0.5 oz,Contours Nutri-Contour - 15ml/0.5oz,Nutri-Contour Repairing Eyes & Lips Creme Creme,Nutri-Contour Repairing Eyes & Lips Creme by Yonka for Unisex - 0.5 oz Creme,Yonka Nutri-Contour Repairing Eye and Lip 0.5-ounce Cream,Yonka Nutri-Contour Repairing Eyes and Lips Creme for Unisex,0.5 Ounce,Yonka Contours Nutri-Contour 15ml/0.5oz,Yon-Ka Contours - Nutri-Contour 0.53 oz,Yon-Ka Paris Skincare Nutri Contour,Yonka-nutri-contour Repairing Eyes & Lips Creme - 1983264 - Personal Care Cosmet}'
);

INSERT INTO products (names) VALUES (
  '{Vichy LIFTACTIV Supreme Night Cream 50ml,Vichy LiftActiv Anti-Wrinkle & Firming Night Care 50ml,Vichy LiftActiv Night Complete Anti-Wrinkle and Firming Care 50ml,Vichy LiftActiv Night Global Anti-Wrinkle & Firming Care 50ml/1.69oz,Vichy Liftactiv Night Supreme Global Anti-wrinkle & Firming Care 50ml,Vichy Liftactiv Supreme Night / Nuit 50 Ml / 1.5 Oz Brand,Vichy Liftactiv Night Supreme Anti-wrinkle And Firming Night Cream,Vichy LiftActiv Night Moisturizer,1.69 Fluid Ounce,Vichy Laboratoires LiftActiv Complete Anti-Wrinkle & Firming Care Cream,Vichy Laboratoires LiftActiv Night Rhamnose 5%,1.7 fl oz,Vichy LiftActiv Derm Source Night (N/A) Skincare Treatment,Vichy LiftActiv DS Night with Rhamnose  50 Ml,Vichy LiftActiv DS Night Anti-Wrinkle Face Cream Rhamnose Complete Care 50 Ml,Vichy LiftActiv Derm Source Night - 50 ml}'
);

INSERT INTO products (names) VALUES (
  '{Eminence Citrus and Kale Potent C + E Masque,Eminence Organics Citrus & Kale Potent C+E Masque 2 oz NEW,Eminence Citrus & Kale Potent C+e Masque - 2oz,Eminence Organics Citrus & Kale Potent C+E Masque NEW}'
);

INSERT INTO products (names) VALUES (
  '{Dr. Brandt Xtend Your Youth Lip Filler & Volumizer,Dr Brandt Xtend Your Youth Lip Filler & Volumizer In Box Full Size,Lineless Lines No More For Lips by Dr. Brandt for Unisex - 0.25 oz Treatment,Lineless Lines No More For Lips by Dr. Brandt - 13379491801,Dr. Brandt Xtend Your Youth Lip Filler & Volumizer 7.5ml For Her Brand,Dr.Brandt 0.25 oz Lineless Lines No More For Lips,Dr. Brandt Lineless Lines No More For Lips 7.5g/0.25oz,dr. brandt XYY Lip Filler and Plumper,Lineless Lines No More For Lips Dr. Brandt 0.25 oz Treatment Unisex,Lineless Lines No More Filler & Volumizer,Dr. Brandt Xtend Your Youth Lip Filler Volumizer 7.5g,Dr. Brandt Skincare Xtend Your Youth Lip Filler & Volumizer 0.26 oz,dr. Brandt lineless lines no more for lips,.25 oz,dr. brandt Xtend Your Youth Lip Filler & Volumizer,Dr. Brandt 13379491801 Lineless Lines No More For Lips - 7.5g-0.25oz,Dr Brandt Lineless Lines No More for Lips 0.25oz,Dr. Brandt Xtend Your Youth Lip Smoother 7.5g,Dr. Brandt Xtend Your Youth Lip Smoother (7.5ml)}'
);
